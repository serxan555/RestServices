package az.dea.services;

import az.dea.manager.DataManager;
import az.dea.manager.StudentRepository;
import az.dea.model.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path(value = "student")
public class StudentServices {

    /////////// QueryParam
//    @Path(value = "getText")
//    @GET
//    @Produces(MediaType.TEXT_HTML)
//    public String getText(@QueryParam(value = "name")String name,
//                          @QueryParam(value = "surname")String surname,
//                          @QueryParam(value = "age")int age){
//        return "<h1>Hello "+name+" "+surname+" "+age+"</h1>";
//    }
//    http://localhost:8585/services/student/getText?name=Serxan&surname=Semedbeyli&age=24

    /////////// QueryParam list ile
//    @Path(value = "getText")
//    @GET
//    @Produces(MediaType.TEXT_HTML)
//    public String getText(@QueryParam(value = "name")String name,
//                          @QueryParam(value = "surname")List<String> surname,
//                          @QueryParam(value = "age")int age){
//        return "<h1>Hello "+name+" "+surname.toString()+" "+age+"</h1>";
//    }
//    http://localhost:8585/services/student/getText?name=Serxan&surname=Semedbeyli&surname=SS.555&age=24
//    QueryParami List ile yazirsansa, linkden surname yazmaga limitin yoxdur. ne qeder istesen elave et

    /////////// QueryParam list ile
//    @Path(value = "getText")
//    @GET
//    @Produces(MediaType.TEXT_HTML)
//    public String getText(@DefaultValue(value = "Samuran")@QueryParam(value = "name")String name,
//                          @QueryParam(value = "surname")List<String> surname,
//                          @QueryParam(value = "age")int age){
//        return "<h1>Hello "+name+" "+surname.toString()+" "+age+"</h1>";
//    }
//    http://http://localhost:8585/services/student/getText?surname=Semedbeyli&surname=SS.555&age=24
//    Default olaraq hec bir ad gondermesek Samuran adi gedecek







    /////////// PathParam
//    @Path(value = "getText/{name}/{surname}/{age}")
//    @GET
//    @Produces(MediaType.TEXT_HTML)
//    public String getText(@PathParam(value = "name") String name,
//                          @PathParam(value = "surname") String surname,
//                          @PathParam(value = "age") int age){
//        return "<h1>Hello "+name+" "+surname+" "+age+"</h1>";
//    }
//    http://localhost:8585/services/student/getText/Serxan/Semedbeyli/24

    /////////// PathParam list ile
//    @Path(value = "getText/{name}/{surname}/{surname}/{age}")
//    @GET
//    @Produces(MediaType.TEXT_HTML)
//    public String getText(@DefaultValue(value = "Samuran")@PathParam(value = "name") String name,
//                          @DefaultValue(value = "Samuran")@PathParam(value = "surname") List<String> surname,
//                          @PathParam(value = "age") int age){
//        return "<h1>Hello "+name+" "+surname.toString()+" "+age+"</h1>";
//    }
//    http://localhost:8585/services/student/getText/Serxan/Semedbeyli/SS.555/24
//    PathParami List ile yazirsansa Pathda ne qeder teyin etmisense ancaq o qeder deyer elave ede bilersen. Yeni limitli





    //////////// ContextParam ile
//    @Path(value = "getText")
//    @GET
//    @Produces(MediaType.TEXT_HTML)
//    public String getText(@Context UriInfo info){
//
//        String name = info.getQueryParameters().getFirst("name");
//        String surname = info.getQueryParameters().getFirst("surname");
//        int age = Integer.parseInt(info.getQueryParameters().getFirst("age"));
//
//        return "<h1>Hello "+name+" "+surname+" "+age+"</h1>";
//    }
//    http://localhost:8585/services/student/getText?name=SS&surname=.555&age=24


    //////////// ContextParam list ile
//    @Path(value = "getText")
//    @GET
//    @Produces(MediaType.TEXT_HTML)
//    public String getText(@Context UriInfo info){
//
//        String name = info.getQueryParameters().getFirst("name");
//        List<String> surname = info.getQueryParameters().get("surname");
//        int age = Integer.parseInt(info.getQueryParameters().getFirst("age"));
//
//        return "<h1>Hello "+name+" "+surname.toString()+" "+age+"</h1>";
//    }
//    http://localhost:8585/services/student/getText?name=SS&surname=.555&surname=Semedbeyli&age=24


    //////////// QueryParam JSON formatinda
//  Neticenin JSON or XML formatinda gorunmesi ucun Student modelinin uzerinde XmlRootElement annotasiyasi yazilib. ona bax
//    DataManager manager = new DataManager();
//    @Path(value = "getStudent")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Student getStudent(@QueryParam(value = "id") int id){
//
//        Student student = manager.getStudent(5);
//        return student;
//    }
//    http://localhost:8585/services/student/getStudent?id=5

    //////////// QueryParam XML formatinda
//  Neticenin JSON or XML formatinda gorunmesi ucun Student modelinin uzerinde XmlRootElement annotasiyasi yazilib. ona bax
    StudentRepository studentRepository = new StudentRepository();
    @Path(value = "getStudent")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Student getStudent(@QueryParam(value = "id") int id){

        Student student = studentRepository.getStudent(1);
        return student;
    }
//    http://localhost:8585/services/student/getStudent?id=5

}
