package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class ServoController extends LinearOpMode {


    @Override
    public void runOpMode() {

        Servo lServo = hardwareMap.servo.get("lServo");
        Servo rServo = hardwareMap.servo.get("rServo");

        waitForStart();

        lServo.setDirection(Servo.Direction.REVERSE);

        while (opModeIsActive()) {
            if (gamepad1.left_bumper) {
                lServo.setPosition(1);
                rServo.setPosition(1);
            }
            if (gamepad1.right_bumper) {
                lServo.setPosition(0);
                rServo.setPosition(0);
            }
        }
    }
}
