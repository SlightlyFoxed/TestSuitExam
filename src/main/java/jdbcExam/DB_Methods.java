package jdbcExam;


import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
public class DB_Methods {
    private static final DB_Props dbProps = DB_Props.conf;

    private static final String INSERT_TO_HUMAN = "INSERT INTO human VALUES(?,?,?,?,?,?,?)";

    private static final String INSERT_TO_BRANCHES = "INSERT INTO branches VALUES (?,?)";



    public static void driverConnection(){

        System.out.println("Test connection to PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
    }




    public static void addToTable (BasicDataSource dataSource, String insertTable,String name,String surname,String middlename,int salary,String branch,int age,String gender) {
        try (Connection con = dataSource.getConnection()){
            PreparedStatement preparedStatement = con.prepareStatement(insertTable);
            if (insertTable.equals(INSERT_TO_HUMAN)) {
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, surname);
                preparedStatement.setString(4, middlename);
                preparedStatement.setInt(5, salary);
                preparedStatement.setString(6, branch);
                preparedStatement.setInt(7, age);
                preparedStatement.setString(8, gender);
            } else {
                System.out.println("Выбрана неверная таблица");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public static void addToTable (BasicDataSource dataSource, String insertTable,String city,int numberOfEmployees) {
            try (Connection con = dataSource.getConnection()){
                PreparedStatement preparedStatement= con.prepareStatement(insertTable);
                if (insertTable.equals(INSERT_TO_BRANCHES)) {
                    preparedStatement.setString(2,city);
                    preparedStatement.setInt(3,numberOfEmployees);
                }else {
                    System.out.println("Выбрана неверная таблица");
                }
            }
            catch (SQLException e){
                e.printStackTrace();
            }
    }
    public static void executeStatement (BasicDataSource pool, String script)throws SQLException{
        try (Connection connection = pool.getConnection()){
            final PreparedStatement ps = connection.prepareStatement(script);
            ps.execute();
        }
    }
    public static void humanTable (BasicDataSource pool, String script) throws SQLException{
        try (Connection con = pool.getConnection()){
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(script);

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String middlename = rs.getString("middlename");
                String branch = rs.getString("branch");
                String gender = rs.getString("gender");
                int salary = rs.getInt("salary");
                int age = rs.getInt("age");
                System.out.println("id " + id +
                        ", name " + name +
                        ", surname " + surname +
                        ", middlename "+ middlename +
                        ", branch " + branch +
                        ", gender " + gender +
                        ", salary " + salary +
                        ", age " + age);
            }
        }
    }
    public static void getHumanzTable(BasicDataSource pool, String script) throws SQLException {
        try (Connection con = pool.getConnection()){
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(script);
            while (rs.next()){
                Human human = new Human();
                human.setId(rs.getInt("id"));
                human.setName(rs.getString("name"));
                human.setSurname(rs.getString("surname"));
                human.setMiddlename(rs.getString("middlename"));
                human.setBranch(rs.getString("branch"));
                human.setGender(rs.getString("gender"));
                human.setSalary(rs.getInt("salary"));
                human.setAge(rs.getInt("age"));

                System.out.println(human);

            }
        }
    }

}
