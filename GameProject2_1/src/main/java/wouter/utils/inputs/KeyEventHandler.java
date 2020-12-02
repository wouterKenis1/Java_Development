package wouter.utils.inputs;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Pair;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import wouter.MainApp;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class KeyEventHandler implements EventHandler<KeyEvent> {

    Vector<Pair<Scene, Pair<KeyCode,Runnable>>> inputFunctions = new Vector<>();
    MainApp app;

    public KeyEventHandler(MainApp app){
        this.app = app;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        //System.out.println(keyEvent.getCode());
        KeyCode code = keyEvent.getCode();
        Stage activeStage = (Stage) app.m_Groups.get(app.m_CurrentGroupIndex).m_Scene.getWindow();

        Vector<Runnable> toRun = new Vector<>();

        for(Pair<Scene, Pair<KeyCode,Runnable>> pair : inputFunctions){
            if(pair.getKey() == activeStage.getScene()){
                if(pair.getValue().getKey() == code){
                    toRun.add(pair.getValue().getValue());
                }
            }
        }

        for(Runnable method : toRun){
            method.run();
        }

    }


    public void addInput(Scene scene, KeyCode code, Runnable function){
        inputFunctions.add(new Pair<>(scene,new Pair<>(code,function)));
    }
}
