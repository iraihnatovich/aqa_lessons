import org.testng.annotations.BeforeSuite;

public class BaseCalcTest  {
//    protected Calculator  calculator ;
    protected Calculator  calculator = new Calculator(); //вынесла сюда, ибо если иниц в @BeforeSuite ---> NUllPointerExc при запуске группы

//    @BeforeSuite(groups = {"general", "extended"})
    @BeforeSuite
    public void initCalculator(){
//        calculator = new Calculator();
    }
}
