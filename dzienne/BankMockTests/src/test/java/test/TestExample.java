package test;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Krzysztof Podlaski on 08.04.2019.
 */
public class TestExample {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    InputStream s;

    @Test
    public void init() throws IOException {
        assertTrue(true);
        int i =s.available();
        assertEquals(0,i);
    }
}
