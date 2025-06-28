package com.pharmacy.warehouse.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class LoggingAspectTest {

    @Test
    void testLogBefore() {
        LoggingAspect aspect = new LoggingAspect();

        JoinPoint mockJoinPoint = mock(JoinPoint.class);
        Signature mockSignature = mock(Signature.class);
        when(mockJoinPoint.getSignature()).thenReturn(mockSignature);
        when(mockSignature.toString()).thenReturn("MockedMethod()");

        aspect.logBefore(mockJoinPoint);

        verify(mockJoinPoint, times(1)).getSignature();
    }
}
