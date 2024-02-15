import { Button, CustomFlowbiteTheme } from "flowbite-react";

const LoginButtonTheme: CustomFlowbiteTheme["button"] = {
  color: {
    blue: "text-white bg-blue border border-transparent enabled:hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800",
  },
};

interface SubmitButtonProps {
  onNext: () => void;
}

export default function SubmitButton({ onNext }: SubmitButtonProps) {
  return (
    <Button
      theme={LoginButtonTheme}
      color="blue"
      onClick={onNext}
      className="w-full"
    >
      <span className="text-xl font-bold">완료</span>
    </Button>
  );
}
