package ru.tuzov.restchooser.to;

import ru.tuzov.restchooser.HasId;

public abstract class BaseTo implements HasId {
    protected Integer id;

    protected BaseTo() {
    }

    protected BaseTo(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
