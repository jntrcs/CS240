package edu.byu.cs.superasteroids.ship_builder;

import edu.byu.cs.superasteroids.base.IView;
import edu.byu.cs.superasteroids.content.ContentManager;

/**
 * Created by jntrcs on 2/19/16.
 */
public class BuilderController implements IShipBuildingController {

    private IShipBuildingView view;

    public BuilderController(IShipBuildingView v)
    {
        view = v;
    }

    @Override
    public void onViewLoaded(IShipBuildingView.PartSelectionView partView) {

    }

    @Override
    public void update(double elapsedTime) {

    }

    @Override
    public void loadContent(ContentManager content) {

    }

    @Override
    public void unloadContent(ContentManager content) {

    }

    @Override
    public void draw() {

    }

    @Override
    public void onSlideView(IShipBuildingView.ViewDirection direction) {

    }

    @Override
    public void onPartSelected(int index) {

    }

    @Override
    public void onStartGamePressed() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public IView getView() {
        return null;
    }

    @Override
    public void setView(IView view) {

    }
}
