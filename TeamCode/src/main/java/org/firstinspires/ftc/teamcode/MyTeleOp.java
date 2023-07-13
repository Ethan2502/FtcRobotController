package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class MyTeleOp extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        ElapsedTime time = new ElapsedTime();



        while (opModeIsActive()) {
            if (gamepad1.a) {
                time.reset();
            }
            telemetry.addLine("It has been " + Math.round(time.milliseconds()/1000) + " seconds");
            telemetry.update();
        }
    }
}
