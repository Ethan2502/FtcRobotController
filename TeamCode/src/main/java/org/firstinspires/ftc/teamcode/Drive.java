package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class Drive extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor lfront = hardwareMap.dcMotor.get("Left front");
        DcMotor rfront = hardwareMap.dcMotor.get("Right front");
        DcMotor lback = hardwareMap.dcMotor.get("Left back");
        DcMotor rback = hardwareMap.dcMotor.get("Right back");

        waitForStart();

        rback.setDirection(DcMotorSimple.Direction.FORWARD);
        lback.setDirection(DcMotorSimple.Direction.REVERSE);
        rfront.setDirection(DcMotorSimple.Direction.FORWARD);
        lfront.setDirection(DcMotorSimple.Direction.REVERSE);

        while (opModeIsActive()) {
            //forward & backward
            double forwardBackward = gamepad1.left_stick_y*-0.5;
            /*lfront.setPower(gamepad1.left_stick_y*-0.5);
            rfront.setPower(gamepad1.left_stick_y*-0.5);
            lback.setPower(gamepad1.left_stick_y*-0.5);
            rback.setPower(gamepad1.left_stick_y*-0.5);
               */
            //turning
            double turning = gamepad1.right_stick_x*0.5;
            /*lfront.setPower(gamepad1.right_stick_x*0.5);
            rfront.setPower(gamepad1.right_stick_x*-0.5);
            lback.setPower(gamepad1.right_stick_x*0.5);
            rback.setPower(gamepad1.right_stick_x*-0.5);
            */
            //mecanuming
            double mecanuming = gamepad1.left_stick_x*0.5;
            //Everything
            lfront.setPower(forwardBackward + turning + mecanuming);
            rfront.setPower(forwardBackward - turning - mecanuming);
            lback.setPower(forwardBackward + turning - mecanuming);
            rback.setPower(forwardBackward - turning + mecanuming);

        }
    }



}
