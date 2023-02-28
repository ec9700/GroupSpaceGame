package com.mygdx.game.Components;

import com.rectgdx.Component;

public class PlayerController extends Component {
    @Override
    public void initial() {
        //Initial() runs once
        //Put any code that should only run once (or needs to be reset after pooling)
        //If you need to set a default value of a variable, set it here (look up pooling or message me if you want to know why)

    }

    @Override
    public void update() {
        //Update() runs every frame
        //Puts things that need to update here
        System.out.println(parent.getPositionVec2());
        //You can access the player by using parent ^^^

    }
}
