package com.a.eye.skywalking.context;

import com.a.eye.skywalking.model.Span;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class CurrentThreadSpanStackTest {

    @Test
    public void testStack(){
        Span rootSpan = new Span("test","test","Test");
        Span subSpan1 = new Span("test","0", 10, "test","Test");
        Span subSpan2 = new Span("test","0", 10, "test","Test");
        CurrentThreadSpanStack.push(rootSpan);

        CurrentThreadSpanStack.push(subSpan1);
        Span span = CurrentThreadSpanStack.peek();
        assertEquals(0, span.getLevelId());
        CurrentThreadSpanStack.pop();

        CurrentThreadSpanStack.push(subSpan2);
        span = CurrentThreadSpanStack.peek();
        assertEquals(1, span.getLevelId());
        CurrentThreadSpanStack.pop();

        CurrentThreadSpanStack.pop();
    }


}