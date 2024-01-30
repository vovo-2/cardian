import { Progress } from 'flowbite-react';
import { ProgressTheme } from '../../themes/ProgressBarTheme';

type ProgressBarProps = {
  value: number,
  total: number,
};

export default function ProgressBar({ value, total }: ProgressBarProps) {
  const progress = value / total * 100;

  return (
    <Progress theme={ProgressTheme} progress={progress} color="blue" />
  )
}
