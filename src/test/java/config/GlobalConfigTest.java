package config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GlobalConfigTest {

    @Test
    void getSingleInstanceOfGlobalConfig() {

        //given
        GlobalConfig gc1=GlobalConfig.getInstance();
        GlobalConfig gc2=GlobalConfig.getInstance();

        //then
        assertEquals(gc1,gc2);

    }
}