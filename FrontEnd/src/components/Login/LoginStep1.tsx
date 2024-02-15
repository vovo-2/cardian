import { useState, ChangeEvent, useEffect } from "react";

interface LoginStep1Props {
  onNameChange: (e: ChangeEvent<HTMLInputElement>) => void;
  onResidentRegistrationNumberChange: (
    residentRegistrationNumber: string
  ) => void;
}

export default function LoginStep1({
  onNameChange,
  onResidentRegistrationNumberChange,
}: LoginStep1Props) {
  const [frontResidentNumber, setFrontResidentNumber] = useState("");
  const [backResidentNumber, setBackResidentNumber] = useState("");

  const handleFrontResidentNumber = (e: ChangeEvent<HTMLInputElement>) => {
    setFrontResidentNumber(e.target.value);
  };
  const handleBackResidentNumber = (e: ChangeEvent<HTMLInputElement>) => {
    setBackResidentNumber(e.target.value);
  };

  useEffect(() => {
    onResidentRegistrationNumberChange(
      `${frontResidentNumber}-${backResidentNumber}`
    );
  }, [
    frontResidentNumber,
    backResidentNumber,
    onResidentRegistrationNumberChange,
  ]);

  return (
    <div className="row-start-3">
      <div className="tablet:text-4xl mobile:text-2xl row-span-2 flex flex-col justify-center tablet:mb-12 mobile:mb-10">
        <div className="mb-3">
          <span className="text-blue font-bold">본인인증</span>을 위한
        </div>
        <div>정보를 입력해주세요.</div>
      </div>

      <div className="mb-10">
        <div>
          <label htmlFor="name" className="text-gray text-sm">
            이름
          </label>
        </div>
        <input
          type="text"
          id="name"
          className="border border-t-0 border-l-0 border-r-0 border-gray w-full"
          onChange={onNameChange}
        />
      </div>
      <div>
        <div>
          <label htmlFor="resident" className="text-gray text-sm">
            주민등록번호
          </label>
        </div>
        <div className="flex">
          <input
            type="text"
            id="resident"
            className="border border-t-0 border-l-0 border-r-0 border-gray w-full"
            onChange={handleFrontResidentNumber}
            maxLength={6}
          />
          <div>__</div>
          <input
            type="text"
            id="resident-back"
            className="border border-t-0 border-l-0 border-r-0 border-gray w-full"
            onChange={handleBackResidentNumber}
            maxLength={7}
          />
        </div>
      </div>
    </div>
  );
}
