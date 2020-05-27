package com.fsy.sharding.config;

/**
 * @Title: DataSourceConfig
 * @Description:
 * @Team: 财务产品研发部
 * @Author fangsy
 * @Date 2020-05-27
 */
public class DataSourceConfig {

    @Autowired
    private Filter statFilter;

    private static final String SHARDING_YML_PATH = "sharding/dataSource.yml";

    /**
     * 构建dataSource
     * 这里没有使用ShardingDataSourceFactory
     * 因为要为durid数据源配置监听Filter
     * @return
     * @throws SQLException
     * @throws IOException
     */
    @Bean
    public DataSource dataSource() throws SQLException, IOException {
        YamlShardingConfiguration config = parse();
        ShardingRule rule = config.getShardingRule(Collections.<String, DataSource>emptyMap());
        rule.getDataSourceMap().forEach((k,v)->{
            DruidDataSource d = (DruidDataSource) v;
            d.setProxyFilters(Lists.newArrayList(statFilter));
        });
        return new ShardingDataSource(rule, config.getShardingRule().getConfigMap(), config.getShardingRule().getProps());
    }

    /**
     * 解析yml
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    private YamlShardingConfiguration parse() throws IOException, FileNotFoundException, UnsupportedEncodingException {
        Resource certResource = new ClassPathResource(SHARDING_YML_PATH);
        try (
                InputStreamReader inputStreamReader = new InputStreamReader(certResource.getInputStream(), "UTF-8")
        ) {
            return new Yaml(new Constructor(YamlShardingConfiguration.class)).loadAs(inputStreamReader, YamlShardingConfiguration.class);
        }
    }

————————————————
    版权声明：本文为CSDN博主「菜鸟里根」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    原文链接：https://blog.csdn.net/sunqingzhong44/article/details/84791074
}
