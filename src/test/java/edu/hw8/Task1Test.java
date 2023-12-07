package edu.hw8;

import edu.hw8.Task1.Client;
import edu.hw8.Task1.MultiThreadClient;
import edu.hw8.Task1.Server;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test void objects_areInstancesOf_CorrectClasses_Test() {
        Client client = new Client(1);
        Server server = new Server(1);
        MultiThreadClient multiThreadClient = new MultiThreadClient(1, 1);

        assertThat(client).isInstanceOf(Client.class);
        assertThat(server).isInstanceOf(Server.class);
        assertThat(multiThreadClient).isInstanceOf(MultiThreadClient.class);
    }
}
