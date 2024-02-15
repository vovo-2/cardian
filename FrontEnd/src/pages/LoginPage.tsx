import { ChangeEvent, useState } from "react";
import { useNavigate } from "react-router-dom";

import { axios } from "../api";
import useAuthStore from "../store/AuthStore";

import TopBar from "../layouts/TopBar";
import LoginStep1 from "../components/Login/LoginStep1";
import LoginStep2 from "../components/Login/LoginStep2";
import PrevButton from "../components/Login/PrevButton";
import NextButton from "../components/Login/NextButton";
import SubmitButton from "../components/Login/SubmitButton";

// TODO: 데이터 받아오기 전까지 로딩 UI 추가
export default function LoginPage() {
  const [currentStep, setCurrentStep] = useState(1);
  const [name, setName] = useState("");
  const [residentRegistrationNumber, setResidentRegistrationNumber] =
    useState("");
  const [isPhoneNumberValid, setIsPhoneNumberValid] = useState(false);
  const [phoneNumber, setPhoneNumber] = useState("");

  const navigate = useNavigate();
  const { login } = useAuthStore();

  const prevStep = () => {
    setCurrentStep((prevStep) => prevStep - 1);
  };
  const nextStep = () => {
    if (currentStep === 2) {
      if (isPhoneNumberValid === false) {
        alert("휴대전화번호를 확인해주세요!");
        return;
      }
      axios
        .post(
          "/user/login",
          {
            name,
            residentRegistrationNumber,
            phoneNumber,
          },
          { withCredentials: true }
        )
        .then(({ data }) => {
          const memberId = data.memberId;
          const name = data.name;
          if (memberId) {
            login(memberId, name);
            navigate("/");
          }
        })
        .catch((error) => {
          console.error("Login Failed:", error);

          alert("존재하지 않는 정보입니다!");
        });

      return;
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
    if (e.target.value.length === 11) {
      setIsPhoneNumberValid(true);
    } else {
      setIsPhoneNumberValid(false);
    }
  };

  const renderCurrentStepForm = (currentStep: number) => {
    switch (currentStep) {
      case 1:
        return (
          <LoginStep1
            onNameChange={handleNameChange}
            onResidentRegistrationNumberChange={
              handleResidentRegistrationNumberChange
            }
          />
        );
      case 2:
        return (
          <LoginStep2
            onPhoneNumberChange={handlePhoneNumberChange}
            isPhoneNumberValid={isPhoneNumberValid}
          />
        );
    }
  };

  return (
    <div className="h-full grid grid-rows-12">
      <TopBar />

      {renderCurrentStepForm(currentStep)}

      <div className="row-end-13 mb-[16px] flex gap-5">
        {currentStep !== 1 && <PrevButton onPrev={prevStep} />}
        {currentStep === 1 && <NextButton onNext={nextStep} />}
        {currentStep === 2 && <SubmitButton onNext={nextStep} />}
      </div>
    </div>
  );
}
