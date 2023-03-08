package com.mygdx.game.Components;

import com.rectgdx.Component;
import com.rectgdx.KeyBinder;
import com.rectgdx.TimeManager;

public class PlayerController extends Component {
    private float speed = 0;

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
        float accelerate = 10;
        if (KeyBinder.getKeyDown("accelerate")) {
            speed= speed+ accelerate * TimeManager.getDeltaTime();
        }
        else if (KeyBinder.getKeyDown("decelerate")) {
            speed= speed - accelerate * TimeManager.getDeltaTime();
        }
        parent.lookAt(KeyBinder.getMousePosVec2());
        parent.move(parent.getNewTrajectoryVec2(KeyBinder.getMousePosVec2()).scl(speed));
        if(parent.testAdjacentCollisionAt(0,0,parent.getHitBoxWidth(),parent.getHitBoxHeight())){
            parent.getAdjacentColliderAt(0,0,parent.getHitBoxWidth(),parent.getHitBoxHeight()).delete();
            System.out.println("collide");
            speed = 0.8F;

        }
    }
}