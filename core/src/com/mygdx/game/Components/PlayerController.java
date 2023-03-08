package com.mygdx.game.Components;

import com.rectgdx.Component;
import com.rectgdx.KeyBinder;

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
        if (KeyBinder.getKeyDown("accelerate")) {
            //logic for acceleration
        }
        if (KeyBinder.getKeyDown("decelerate")) {
            //logic for deceleration
        }
        if (KeyBinder.getKeyDown("left")) {
            //logic for side movement
        }
        if (KeyBinder.getKeyDown("right")) {
            //logic for side movement
        }
        if (KeyBinder.getKeyDown("fire")) {
            //logic for primary weapon
        }
        if (KeyBinder.getKeyDown("fire2")) {
            //logic for secondary weapon
        }

        System.out.println(parent.getPositionVec2());
        //You can access the player by using parent ^^^

        //IF YOU HAVE USED Rectsprite.noArgs(), REMOVE IT FROM YOU CODE!

    }
}
