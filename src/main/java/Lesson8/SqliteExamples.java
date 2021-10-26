package Lesson8;

import java.sql.*;

public class SqliteExamples {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        //CRUD - Create/Read/Update/Delete

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:geekbrains.db");
            statement = connection.createStatement();
            int count = statement.executeUpdate("update students set name = 'Malkovich' where name = 'Malcovich'");
            preparedStatement = connection.prepareStatement(
                    "insert into students ( name, score, fac_id) values (?, ?, ?)");
            preparedStatement.setString(1, "Pitt");
            preparedStatement.setInt(2, 10);
            preparedStatement.setInt(3, 5);
            preparedStatement.addBatch();
            preparedStatement.setString(1, "Jackson");
            preparedStatement.setInt(2, 9);
            preparedStatement.setInt(3, 2);
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
            ResultSet resultSet = statement.executeQuery("select * from students");
            while (resultSet.next()) {
                System.out.print(resultSet.getString("name") + ", ");
                System.out.println(resultSet.getInt("fac_id"));
            }
            System.out.println(count);
            /*Method to edd records to DB
            AutoCommit default is true; change to false to commit all records together but not one by one

            connection.setAutoCommit(false);
            for (int i = 0; i < 10000; i++){
                statement.executeUpdate(String.format(
                        "insert into students (name, score, fac_id) values ('%s', %d, %d)", "Student" + i, i));
            }
            connection.commit();
            */

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
