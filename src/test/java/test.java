import com.dao.StudentDao;
import com.pojo.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author WDY
 * @Date 2020-09-20 14:48
 * @Description TODO
 */
public class test {
    private SqlSession sqlSession;
    private StudentDao studentDao;
    private long x;

    @Before
    public void loadConfig() throws IOException {
        //1.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("config.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        //3.加载配置文件
        SqlSessionFactory build = ssfb.build(inputStream);
        //4.使用工厂生产SQLSession(开启自动提交)
        sqlSession = build.openSession(true);
        //5.使用SQLSession创建Dao接口的代理对象
        studentDao = sqlSession.getMapper(StudentDao.class);

    }

    /**
     * 添加学生
     */
    @Test
    public void addStudent(){
        Student student = new Student();
        student.setAge(14);
        student.setName("牛少杰");
        student.setScore(98.1);
        studentDao.addStudent(student);
    }

    /**
     * 批量添加学生
     */
    @Test
    public void testAddStudent(){

        String firstName = "赵 钱 孙 李 周 吴 郑 王 冯 陈 褚 卫 蒋 沈 韩 杨 朱 秦 尤 许 何 吕 施 张 孔 曹 严 华 金 魏 陶 姜 戚 谢 邹 喻 柏 水 窦 章 云 苏 潘 葛 奚 范 彭 郎 鲁 韦 昌 马 苗 凤 花 方 俞 任 袁 柳 酆 鲍 史 唐 费 廉 岑 薛 雷 贺 倪 汤 滕 殷 罗 毕 郝 邬 安 常 乐 于 时 傅 皮 卞 齐 康 伍 余 元 卜 顾 孟 平 黄 和 穆 萧 尹 姚 邵 湛 汪 祁 毛 禹 狄 米 贝 明 臧 计 伏 成 戴 谈 宋 茅 庞 熊 纪 舒 屈 项 祝 董 梁 杜 阮 蓝 闵 席 季 麻 强 贾 路 娄 危 江 童 颜 郭 梅 盛 林 刁 钟 徐 邱 骆 高 夏 蔡 田 樊 胡 凌 霍 虞 万 支 柯 昝 管 卢 莫 经 房 裘 缪 干 解 应 宗 丁 宣 贲 邓 郁 单 杭 洪 包 诸 左 石 崔 吉 钮 龚 程 嵇 邢 滑 裴 陆 荣 翁 荀 羊 於 惠 甄 曲 家 封 芮 羿 储 靳 汲 邴 糜 松 井 段 富 巫 乌 焦 巴 弓 牧 隗 山 谷 车 侯 宓 蓬 全 郗 班 仰 秋 仲 伊 宫 宁 仇 栾 暴 甘 钭 厉 戎 祖 武 符 刘 景 詹 束 龙 叶 幸 司 韶 郜 黎 蓟 薄 印 宿 白 怀 蒲 台 从 鄂 索 咸 籍 赖 卓 蔺 屠 蒙 池 乔 阴 欎 胥 能 苍 双 闻 莘 党 翟 谭 贡 劳 逄 姬 申 扶 堵 冉 宰 郦 雍 郤 璩 桑 桂 濮 牛 寿 通 边 扈 燕 冀 郏 浦 尚 农 温 别 庄 晏 柴 瞿 阎 充 慕 连 茹 习 宦 艾 鱼 容 向 古 易 慎 戈 廖 庾 终 暨 居 衡 步 都 耿 满 弘 匡 国 文 寇 广 禄 阙 东 殴 殳 沃 利 蔚 越 夔 隆 师 巩 厍 聂 晁 勾 敖 融 冷 訾 辛 阚 那 简 饶 空 曾 毋 沙 乜 养 鞠 须 丰 巢 关 蒯 相 查 后 荆 红";
        String lastName = "梁鸿 诚桓 权泽 福年 家荣 锐骏 仕禄 颜日 俊震 杰中 盛年 良锟 礼振 强卓 家逸 贤欣 暄斌 阳良 盛浩 帆峰 翰哲 远鸿 诚初 祥恒 强锋 康涛 年琛 鹏盛 子锋 谛畅 钊禧 材贤 弘日 潍逸 琛炳 勇槐 祜郁 祜礼 俊康 铭延 荣槐 子林 铭澄 禄伟 乘运 栋蔓 裕俊 骞礼 德帆 加琛 辰嘉 凯侠 彬祜 锋泽 锋濡 喆鹏 桓卓 安吉 权运 远澄 卓钊 吉德 材鹏 腾允 勇权 奇林 强浩 尧芃 逸福 梁侠 澄盛 星禧 运日 贤振 鑫德 尧恒 烁嘉 卓澄 伟喆 翱年";
        String[] firstNames = firstName.split(" ");
        String[] lastNames = lastName.split(" ");
        Random random = new Random();
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            int i1 = random.nextInt(firstNames.length);
            int i2 = random.nextInt(lastNames.length);
            Student student = new Student();
            student.setAge(random.nextInt(100));
            student.setName(firstNames[i1]+lastNames[i2]);
            student.setCid(random.nextInt(3)+1);
            student.setScore(Double.valueOf(String.format("%.2f",random.nextDouble()*100)));
            list.add(student);

        }
        studentDao.batchAddStudent(list);
    }


    /**
     * 删除学生
     */
    @Test
    public void delStudent(){
        studentDao.delStudentById(4);
    }

    /**
     * 批量删除学生
     */
    @Test
    public void batchDelStudents(){
        List<Integer> list = Arrays.asList(50001, 50000, 49999, 49998);
        studentDao.batchDelStudents(list);
    }

    /**
     * 更新学生
     */
    @Test
    public void upStudent(){
        Student student = new Student();
        student.setName("牛烧结");
        student.setId(2);
        student.setScore(60.1);
        student.setAge(20);
        studentDao.updateStudentById(student);

    }
    /**
     * 查找一个学生
     */
    @Test
    public void findOneStudent(){

        System.out.println(studentDao.findById(1));
    }
    /**
     * 查找所有学生
     */
    @Test
    public void findAllStudent(){
        studentDao.finAll().forEach(stu-> System.out.println(stu));
    }

    /**
     *通过多条件查询
     */
    @Test
    public void findByConditons(){
        Student student = new Student();
        student.setScore(1d);
        student.setId(1);
        List<Student> students = studentDao.findByConditions(student);
        students.forEach(System.out::println);
    }

    /**
     * 通过多条件更新
     */
    @Test
    public void updateByConditions(){
        Student student = new Student();
        student.setScore(99.9);
        student.setId(1);
        studentDao.updateByConditions(student);
    }

    /**
     * 多表联合查询
     * 一对多
     */
    @Test
    public void mulitFind(){
        Student student = studentDao.mulitFind(1);
        Integer age = student.getAge();
        //System.out.println(student.toString());
    }

    /**
     * 模糊查询
     */
    @Test
    public void findByLikeName(){
        List<Student> lists = studentDao.findByLikeName("王");
        lists.forEach(System.out::println);
    }

    /**
     * 多表联合查询
     * 多对多
     */
    @Test
    public void manyToMany(){
        List<Student> students = studentDao.manyToMany(null);
        students.forEach(System.out::println);
    }

    /**
     *查询各省级联关系(子类)
     */
    @Test
    public void findCategoryLevelFirst(){
        long timeMillis = System.currentTimeMillis();
        City categoryLevelFirst = studentDao.findCategoryLevelFirst(11);
        System.out.println(System.currentTimeMillis()-timeMillis);
        System.out.println(categoryLevelFirst);
    }

    /**
     *查询各省级联关系
     */
    @Test
    public void findCategoryLevelFirstByStream(){
        long timeMillis = System.currentTimeMillis();
        List<CityCategory> allCategory = studentDao.findAllCategory(null);
        //一级菜单
        List<CityCategory> categoryLevel1 = allCategory.stream().filter(categoryEntity ->
           categoryEntity.getId().equals(11)
        ).peek(menu->{
            //设置子菜单
            menu.setChildren(getChildren(menu,allCategory));
        }).collect(Collectors.toList());
        System.out.println(System.currentTimeMillis()-timeMillis);
        categoryLevel1.forEach(System.out::println);
    }

    private List<CityCategory> getChildren(CityCategory root,List<CityCategory> all){
        List<CityCategory> children = all.stream().filter(categoryEntity ->
                root.getId().equals(categoryEntity.getPid())
        ).peek(categoryEntity -> {
            //查找子菜单
            categoryEntity.setChildren(getChildren(categoryEntity,all));
        }).collect(Collectors.toList());
        return children;
    }

    /**
     * 级联查询（父类）
     */
    @Test
    public void findCategoryParent(){
        CategoryParent categoryParent = studentDao.findCategoryParent(150);
        System.out.println(categoryParent);
    }


    @After
    public void closeSession(){
        sqlSession.close();
    }
}
