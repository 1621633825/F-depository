import com.ruoyi.generator.autocode.DefaultMybatisPlusGenerator;
import org.junit.Test;

public class CodeAutoGeneratorTest {
    @Test
    public void generateModuleCodes() {
        // 数据库名
        String database = "code_auto_genertaor";
        // 文件生成的作者
        String author = "liangliang";
        // 生成的包下面的某个类型的模块，具体的业务模块，里面包含了controller，service，dao，entity等文件夹
        String moduleName = "newtable";
        // 表名
        String[] tableNames = new String[]{
                "newtable",
        };
        // url地址
        String url = "jdbc:mysql://localhost:3306/";
        // 驱动名
        String driverName = "com.mysql.cj.jdbc.Driver";
        // 包名
        String packageName = "com.ruoyi.generator";

        new DefaultMybatisPlusGenerator(database, author, moduleName, tableNames, url, driverName, packageName)
                // 是否生成Controllers
                .setGenerateControllers(true)
                // 是否生成Services
                .setGenerateServices(true)
                // 是否生成Mappers
                .setGenerateMappers(true)
                // 是否生成XMLs
                .setGenerateXMLs(true)
                // 是否生成Entities
                .setGenerateEntities(true)
                // 是否强制覆盖源文件(如果存在)
                .setFileOverride(true)
                .execute();
    }

}
