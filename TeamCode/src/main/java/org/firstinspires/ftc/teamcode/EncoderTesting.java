package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class EncoderTesting extends LinearOpMode {


    @Override
    public void runOpMode() throws InterruptedException {

        DcMotor lFront = hardwareMap.dcMotor.get("Left front");
        DcMotor rFront = hardwareMap.dcMotor.get("Right front");
        DcMotor lBack = hardwareMap.dcMotor.get("Left back");
        DcMotor rBack = hardwareMap.dcMotor.get("Right back");


        rBack.setDirection(DcMotorSimple.Direction.FORWARD);
        lBack.setDirection(DcMotorSimple.Direction.REVERSE);
        rFront.setDirection(DcMotorSimple.Direction.FORWARD);
        lFront.setDirection(DcMotorSimple.Direction.REVERSE);


        lFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);



        waitForStart();

        int ticksTurned = lFront.getCurrentPosition();
        telemetry.addLine(String.valueOf(ticksTurned));
        telemetry.addLine(String.valueOf(lFront.getCurrentPosition()));


        while(opModeIsActive()){

            while (ticksTurned < 380) {

                ticksTurned = lFront.getCurrentPosition();

                telemetry.addLine(String.valueOf(ticksTurned));
                telemetry.addLine(String.valueOf(lFront.getCurrentPosition()));
                telemetry.update();

                lFront.setPower(0.1);
                lBack.setPower(0.1);
                rFront.setPower(0.1);
                rBack.setPower(0.1);
                if (ticksTurned >= 537) {
                    break;
                }
            }
                if (ticksTurned >= 380) {

                    lFront.setPower(0);
                    lBack.setPower(0);
                    rFront.setPower(0);
                    rBack.setPower(0);
                }
        }
    }
}
