import { ChangeEvent } from "react";

interface LoginStep2Props {
  onPhoneNumberChange: (e: ChangeEvent<HTMLInputElement>) => void;
  isPhoneNumberValid: boolean;
}

export default function LoginStep2({
  onPhoneNumberChange,
  isPhoneNumberValid,
}: LoginStep2Props) {
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
          <label htmlFor="carrier" className="text-gray text-sm">
            통신사
          </label>
        </div>
        <select
          name="carrier"
          id="carrier"
          className="border border-t-0 border-l-0 border-r-0 border-gray w-full"
        >
          <option value="skt">SKT</option>
          <option value="kt">KT</option>
          <option value="lg">LG U+</option>
        </select>
      </div>
      <div className="mb-10">
        <div>
          <label htmlFor="carrier" className="text-gray text-sm">
            휴대전화번호
          </label>
        </div>
        <input
          type="tel"
          className="border border-t-0 border-l-0 border-r-0 border-gray w-full"
          onChange={onPhoneNumberChange}
          maxLength={11}
          placeholder="01012345678"
        />
        {!isPhoneNumberValid && (
          <div className="text-xs text-red-600">
            휴대전화번호 숫자 11자리를 입력해주세요.
          </div>
        )}
      </div>
      <div className="mb-10">
        <div>
          <label htmlFor="auth-number" className="text-gray text-sm">
            인증번호
          </label>
        </div>
        <div className="flex">
          <input
            type="tel"
            id="auth-number"
            className="border border-t-0 border-l-0 border-r-0 border-gray w-full mr-4"
          />
          <button className="bg-blue rounded-lg text-white w-1/4 p-3 box-content mobile:text-sm">
            인증요청
          </button>
        </div>
      </div>
    </div>
  );
}
