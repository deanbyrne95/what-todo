package io.github.what.todo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
class ApiApplicationTests {

    @Test
    public void main() {
        ApiApplication.main(new String[]{});
    }

    @Test
    public void configure() {
        new ApiApplication().configure(new SpringApplicationBuilder());
    }

}
