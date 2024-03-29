/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.QueueConstants;
import frc.robot.subsystems.QueueSubsystem;

public class IntakeReverse extends CommandBase {
  QueueSubsystem m_intakeSub;
  /**
   * Creates a new IntakeReverse.
   */
  public IntakeReverse(QueueSubsystem intakeSub) {
    m_intakeSub = intakeSub;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_intakeSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_intakeSub.spinIntake(-QueueConstants.INTAKE_SPEED);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intakeSub.stopIntake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
