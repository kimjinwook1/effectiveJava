package hello.effectivejava.Chap2_객체_생성과_파괴.item7.vo;

public class ResultSet {
    public static ResultSet createResultSet(DBConnection dbConnection){
        System.out.println("DBConnection 에 따른 작업 후 ResultSet 반환");
        return new ResultSet();
    }
}
