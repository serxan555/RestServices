package az.dea.manager;

import az.dea.model.Student;

public class StudentRepository extends DataManager {


    public Student getStudent(int id){
        String query = "select * from students where id = "+id;
        try {
            connect();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                return student;

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                disconnect();
            }catch (Exception e){
            }
        }
        return new Student();
    }
}
