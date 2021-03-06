package com.structurizr.view;

import com.structurizr.model.Element;
import com.structurizr.model.ElementType;
import com.structurizr.model.SoftwareSystem;

public class ContainerView extends View {

    ContainerView() {
    }

    ContainerView(SoftwareSystem softwareSystem, String description) {
        super(softwareSystem, description);
    }

    /**
     * Adds all software systems in the model to this view.
     */
    @Override
    public void addAllSoftwareSystems() {
        getModel().getSoftwareSystems().stream()
                .filter(ss -> ss != getSoftwareSystem())
                .forEach(this::addElement);
    }

    /**
     * Adds all containers in the software system to this view.
     */
    public void addAllContainers() {
        getSoftwareSystem().getContainers().forEach(this::addElement);
    }

    @Override
    public final ViewType getType() {
        return ViewType.Container;
    }

    @Override
    public String getName() {
        return getSoftwareSystem().getName() + " - Containers";
    }

    @Override
    public void addAllElements() {
        addAllSoftwareSystems();
        addAllPeople();
        addAllContainers();
    }

    @Override
    public void addNearestNeighbours(Element element) {
        super.addNearestNeighbours(element, ElementType.SoftwareSystem);
        super.addNearestNeighbours(element, ElementType.Person);
        super.addNearestNeighbours(element, ElementType.Container);
    }

}