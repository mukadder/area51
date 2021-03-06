/*
 * Copyright 2009 David Linsin
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.linsin.sample.reflectionjunit.domain;

import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.expect;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;
import org.joda.time.DateMidnight;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.reflect.Whitebox;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Testing Contract's business logic using easymock & reflection
 *
 * @author David Linsin
 * @version 0.0.1
 * @since 0.0.1
 */
@RunWith(org.junit.internal.runners.JUnit4ClassRunner.class)
public class ContractTest {

    @Test
    public void test_Set_Owner() {
        Contract classUnderTest = new Contract(1L);
        Customer customerMock = createMock(Customer.class);
        assertEquals(BigDecimal.ZERO, classUnderTest.getQuote());

        expect(customerMock.getBirthday()).andReturn(new DateMidnight(1982, 4, 27));
        replay(customerMock);
        classUnderTest.setOwner(customerMock);
        assertTrue(classUnderTest.getQuote().compareTo(BigDecimal.ZERO) >= 1);
        verify(customerMock);
    }

    @Test
    public void test_Calculate_Quote() throws Exception {
        Contract classUnderTest = new Contract(1L);
        BigDecimal quote = (BigDecimal) Whitebox.invokeMethod(classUnderTest, "calculateQuote", new DateMidnight(1982, 4, 27));
        assertEquals(new BigDecimal("8.09"), quote.setScale(2, RoundingMode.FLOOR));
    }
}
