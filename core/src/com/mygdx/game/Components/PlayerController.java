package com.mygdx.game.Components;

import com.rectgdx.Component;

public class PlayerController extends Component {
    @Override
    public void initial() {
        //Initial() runs once
        //Put any code that should only run once (or needs to be reset after pooling)

    }

    @Override
    public void update() {
        //Update() runs every frame
        //Puts things that need to update here
        System.out.println(parent.getPositionVec2());
        //You can access the player by using parent ^^^

    }
}
