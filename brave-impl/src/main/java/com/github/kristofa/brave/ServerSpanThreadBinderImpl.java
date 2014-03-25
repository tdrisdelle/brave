package com.github.kristofa.brave;

import com.twitter.zipkin.gen.Span;
import org.apache.commons.lang3.Validate;

/**
 * {@link ServerSpanThreadBinder} implementation.
 * 
 * @author kristof
 */
class ServerSpanThreadBinderImpl implements ServerSpanThreadBinder {

    private final ServerAndClientSpanState serverSpanState;

    /**
     * Creates a new instance.
     *
     * @param serverSpanState Server span state, should not be <code>null</code>
     */
    public ServerSpanThreadBinderImpl(final ServerAndClientSpanState serverSpanState) {
        Validate.notNull(serverSpanState);
        this.serverSpanState = serverSpanState;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ServerSpan getCurrentServerSpan() {
        return serverSpanState.getCurrentServerSpan();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCurrentSpan(final ServerSpan span) {
        serverSpanState.setCurrentServerSpan(span);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Span getCurrentClientSpan() {
        return serverSpanState.getCurrentClientSpan();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCurrentClientSpan(final Span span) {
        serverSpanState.setCurrentClientSpan(span);
    }
}
