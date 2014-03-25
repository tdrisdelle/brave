package com.github.kristofa.brave;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

public class ServerSpanThreadBinderImplTest {

    private ServerAndClientSpanState mockServerSpanState;
    private ServerSpan mockSpan;
    private ServerSpanThreadBinderImpl binder;

    @Before
    public void setup() {
        mockServerSpanState = mock(ServerAndClientSpanState.class);
        binder = new ServerSpanThreadBinderImpl(mockServerSpanState);
        mockSpan = mock(ServerSpan.class);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorNullState() {
        new ServerSpanThreadBinderImpl(null);
    }

    @Test
    public void testGetCurrentServerSpanNullServerSpan() {
        assertNull(binder.getCurrentServerSpan());
        verify(mockServerSpanState).getCurrentServerSpan();
        verifyNoMoreInteractions(mockServerSpanState);
    }

    @Test
    public void testGetCurrentServerSpan() {

        when(mockServerSpanState.getCurrentServerSpan()).thenReturn(mockSpan);
        assertSame(mockSpan, binder.getCurrentServerSpan());
        verify(mockServerSpanState).getCurrentServerSpan();
        verifyNoMoreInteractions(mockServerSpanState);
    }

    @Test
    public void testSetCurrentSpanNull() {
        binder.setCurrentSpan(null);
        verify(mockServerSpanState).setCurrentServerSpan(null);
        verifyNoMoreInteractions(mockServerSpanState);
    }

    @Test
    public void testSetCurrentSpan() {
        binder.setCurrentSpan(mockSpan);
        verify(mockServerSpanState).setCurrentServerSpan(mockSpan);
        verifyNoMoreInteractions(mockServerSpanState);
    }

}
