package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class Drive extends LinearOpMode {




    @Override
    public void runOpMode() {
        DcMotor lfront = hardwareMap.dcMotor.get("Left front");
        DcMotor rfront = hardwareMap.dcMotor.get("Right front");
        DcMotor lback = hardwareMap.dcMotor.get("Left back");
        DcMotor rback = hardwareMap.dcMotor.get("Right back");
        DcMotor arm = hardwareMap.dcMotor.get("arm");

        Servo lServo = hardwareMap.servo.get("lServo");
        Servo rServo = hardwareMap.servo.get("rServo");


        lServo.setDirection(Servo.Direction.REVERSE);

        waitForStart();

        rback.setDirection(DcMotorSimple.Direction.FORWARD);
        lback.setDirection(DcMotorSimple.Direction.REVERSE);
        rfront.setDirection(DcMotorSimple.Direction.FORWARD);
        lfront.setDirection(DcMotorSimple.Direction.REVERSE);
        arm.setDirection(DcMotorSimple.Direction.REVERSE);

        while (opModeIsActive()) {
            //forward & backward
            double forwardBackward = gamepad1.left_stick_y * -0.5;
            /*lfront.setPower(gamepad1.left_stick_y*-0.5);
            rfront.setPower(gamepad1.left_stick_y*-0.5);
            lback.setPower(gamepad1.left_stick_y*-0.5);
            rback.setPower(gamepad1.left_stick_y*-0.5);
               */
            //turning
            double turning = gamepad1.right_stick_x * 0.5;
            /*lfront.setPower(gamepad1.right_stick_x*0.5);
            rfront.setPower(gamepad1.right_stick_x*-0.5);
            lback.setPower(gamepad1.right_stick_x*0.5);
            rback.setPower(gamepad1.right_stick_x*-0.5);
            */
            //mecanuming
            double mecanuming = gamepad1.left_stick_x * 0.5;

            //arm up and down
            double armPower = gamepad1.right_stick_y * -0.5;
            //Everything
            lfront.setPower(forwardBackward + turning + mecanuming);
            rfront.setPower(forwardBackward - turning - mecanuming);
            lback.setPower(forwardBackward + turning - mecanuming);
            rback.setPower(forwardBackward - turning + mecanuming);
            arm.setPower(armPower);
        }

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