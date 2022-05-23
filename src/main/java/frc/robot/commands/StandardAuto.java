package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class StandardAuto extends SequentialCommandGroup {
    // put subsystem definitions here

    public StandardAuto (Drivetrain drivetrain){

        addCommands(
          new ParallelRaceGroup(
            new RunCommand
            ()-> drivetrain.drive(0.5, 0)
          ),
          new WaitCommand(2) //seconds
          ),

          new ParallelRaceGroup(
            new RunCommand
            ()-> drivetrain.drive(0, 0.69)
          ),
            new WaitCommand(2)
          ),

          new ParallelRaceGroup(
            new RunCommand
            ()-> drivetrain.drive(0.5, 0)
          ),
            new WaitCommand(2)
          ),

          new ParallelRaceGroup(
            new RunCommand
            ()-> drivetrain.drive(0, 0.69)
          ),
            new WaitCommand(2)
          ),

          new ParallelRaceGroup(
            new RunCommand
            ()-> drivetrain.drive(0.5, 0)
          ),