import { Button, Modal } from "flowbite-react";
import { useEffect, useState, useRef } from "react";
import { ButtonTheme } from "../../themes/ButtonTheme";

import { axios } from "../../api";

interface IncomeProps {
  userName: string;
  salary: number;
  onSetSalary: (salary: number) => void;
}

export default function MyIncome({
  userName,
  salary,
  onSetSalary,
}: IncomeProps) {
  const [openModal, setOpenModal] = useState(false);
  const salaryInputBox = useRef<HTMLInputElement>(null);

  // 현재 연봉정보 받아오기
  const [inputSalary, setInputSalary] = useState(0);

  function setSalary(salary: number) {
    onSetSalary(salary);
  }

  useEffect(() => {
    axios.get("/settlement/1").then(({ data }) => {
      setSalary(data.salary);
      setInputSalary(Math.floor(data.salary / 10000));
    });
  }, []);

  const onChangeHandler = (e: React.ChangeEvent<HTMLInputElement>) => {
    setInputSalary(parseInt(e.target.value));
  };
  const salarySubmitHandler = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
  };

  const onKeyDownHandler = (e: React.KeyboardEvent<HTMLInputElement>) => {
    if (e.key === "Enter") {
      handleSubmit();
    }
  };

  const memberId = 1;

  const handleSubmit = () => {
    const sendSalary = inputSalary * 10000;

    if (sendSalary >= 0 && sendSalary < 1000000000) {
      axios
        .put(`/settlement/${memberId}/${sendSalary}`, { withCredentials: true })
        .then(() => {
          setSalary(sendSalary);
        });
      setOpenModal(false);
    } else if (sendSalary >= 1000000000) {
      alert("10억 이상은 입력할 수 없습니다.")
    }
  };

  return (
    <div>
      <span className="flex justify-center text-2xl">
        <span className="font-semibold">{userName}</span>님의 연봉&nbsp;
        {salary == 0 ? (
          <span>
            <span className="text-blue font-semibold">
              0
            </span>
            원
          </span>
        ) : salary < 100000000 ? (
          <span>
            <span className="text-blue font-semibold">
              {Math.floor(salary / 10000)}만
            </span>
            원
          </span>
        ) : salary / 10000 - Math.floor(salary / 100000000) * 10000 == 0 ? (
          <span>
            <span className="text-blue font-semibold">
              {Math.floor(salary / 100000000)}억
            </span>
            원
          </span>
        ) : (
          <span>
            <span className="text-blue font-semibold">
              {Math.floor(salary / 100000000)}억
              {Math.floor(salary / 10000) -
                Math.floor(salary / 100000000) * 10000}
              만
            </span>
            원
          </span>
        )}
      </span>
      <div className="flex justify-end">
        <Button
          theme={ButtonTheme}
          color="light"
          size="xs"
          onClick={() => setOpenModal(true)}
        >
          수정
        </Button>
        <Modal
          size="md"
          dismissible
          show={openModal}
          onClose={() => setOpenModal(false)}
          initialFocus={salaryInputBox}
        >
          <Modal.Header>연봉 정보 수정</Modal.Header>
          <Modal.Body>
            <span>연봉 정보를 입력해주세요.</span>
            <form className="mt-7" onSubmit={salarySubmitHandler}>
              <div className="flex flex-row items-baseline">
                <input
                  className="outline-none mr-5 rounded-lg w-full"
                  type="number"
                  value={inputSalary}
                  ref={salaryInputBox}
                  onChange={onChangeHandler}
                  onKeyDown={onKeyDownHandler}
                />
                <span className="text-nowrap text-xl">만 원</span>
              </div>
              <div className="flex flex-row justify-end">
                <Button
                  theme={ButtonTheme}
                  //   type="submit"
                  color="blue"
                  onClick={() => {
                    handleSubmit();
                  }}
                  className="mt-3"
                  size="sm"
                >
                  저장
                </Button>
                <Button
                  theme={ButtonTheme}
                  color="gray"
                  onClick={() => setOpenModal(false)}
                  className="ml-2 mt-3"
                  size="sm"
                >
                  취소
                </Button>
              </div>
            </form>
          </Modal.Body>
        </Modal>
      </div>
    </div>
  );
}
