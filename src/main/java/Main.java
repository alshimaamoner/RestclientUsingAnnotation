import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import web.User;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        Client client = ClientBuilder.newClient();
       WebTarget webTarget = client.target("http://localhost:9090/Serverrrrr").path("getNetSalary");
        User user=new User();
        user.setName("sho");
        user.setSalary(10000);
        user.setBouns(122);
        user.setDeduction(1);
        user.setAddress("octobar");
        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
        int netSalary = response.readEntity(Integer.class);

        System.out.println(" Net salary: " + netSalary);
    }
}
