package com.example.akka.iiot.actors.service;

import akka.japi.Creator;
import com.example.akka.iiot.actors.ActorSystemContext;


public abstract class ContextBasedCreator<T> implements Creator<T> {

    private static final long serialVersionUID = 1L;

    protected final transient ActorSystemContext context;

    public ContextBasedCreator(ActorSystemContext context) {
        super();
        this.context = context;
    }
}
