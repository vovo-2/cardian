import { ChangeEvent, useState } from "react";

import TopBar from "../layouts/TopBar";
import LoginStep1 from "../components/Login/LoginStep1";
import LoginStep2 from "../components/Login/LoginStep2";
import PrevButton from "../components/Login/PrevButton";
import NextButton from "../components/Login/NextButton";
import { axios } from "../api";

export default function LoginPage() {
  const [currentStep, setCurrentStep] = useState(1);
  const [name, setName] = useState("");
  const [residentRegistrationNumber, setResidentRegistrationNumber] = useState("");
  const [phoneNumber, setPhoneNumber] = useState("");

  const prevStep = () => {
    setCurrentStep((prevStep) => prevStep - 1);
  };
  const nextStep = () => {
    if (currentStep === 2) {
      axios
        .post(
          "/user/login",
          {
            name,
            residentRegistrationNumber,
            phoneNumber,
          },
          {
            withCredentials: true,
          }
        )
        .then((res) => {
          console.log(res);
        });
    }

    setCurrentStep((prevStep) => prevStep + 1);
  };

  const handleNameChange = (e: ChangeEvent<HTMLInputElement>) => {
    setName(e.target.value);
  };
  const handleResidentRegistrationNumberChange = (residentNumber: string) => {
    setResidentRegistrationNumber(residentNumber);
  };
  const handlePhoneNumberChange = (e: ChangeEvent<HTMLInputElement>) => {
    setPhoneNumber(e.target.value);
  };

  const renderCurrentStepForm = (currentStep: number) => {
    switch (currentStep) {
      case 1:
        return (
          <LoginStep1
            onNameChange={handleNameChange}
            onResidentRegistrationNumberChange={handleResidentRegistrationNumberChange}
          />
        );
      case 2:
        return <LoginStep2 onPhoneNumberChange={handlePhoneNumberChange} />;
    }
  };

  return (
    <div className="h-full grid grid-rows-12">
      <TopBar />

      {renderCurrentStepForm(currentStep)}

      <div className="row-end-13 mb-[16px] flex gap-5">
        {currentStep !== 1 && <PrevButton onPrev={prevStep} />}
        <NextButton onNext={nextStep} />
      </div>
    </div>
  );
}
