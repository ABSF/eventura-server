package pl.eventura.eventuraserver.events;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration()
@AutoConfigureMockMvc
@SpringBootTest
class EventControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void addNewEvent_basicTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/events/add?logo=url&date=1900-01-01&event_category=Music&venue=Warszawa&summary=Opis&name=Koncert")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getEvents_basicTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/events/all")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getEvent_findByDateStart() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/events/search?dateStart=2019-01-01")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getEvent_findByText() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/events/search?text=Ronstring")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getEvent_findByTextAndDates() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/events/search?text=Ronstring&dateStart=2019-01-01&dateEnd=2999-01-01")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getSpecificEvent_basicTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/events/search/1")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}