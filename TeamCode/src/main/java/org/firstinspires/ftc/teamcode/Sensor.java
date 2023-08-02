package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DistanceSensor;

@TeleOp
public class Sensor extends LinearOpMode {



    @Override
    public void runOpMode() throws InterruptedException {

        DistanceSensor cm = hardwareMap.get(DistanceSensor.class, "Distance Sensor");

        waitForStart();

        while (opModeIsActive()){

        }

    }
}
