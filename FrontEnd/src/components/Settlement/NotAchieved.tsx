import ProgressBar from "../ui/ProgressBar";

import { useState, useEffect } from "react"
import { axios } from "../../api"

interface NotAchievedProps {
  userName: string;
  salary: number;
  onSetCheckCard: (consume: number) => void;
  onSetCreditCard: (consume: number) => void;
}

export default function NotAchieved({userName, salary, onSetCheckCard, onSetCreditCard}: NotAchievedProps) {

  const [accumulate, setAccumulate] = useState(0);
  const [goal, setGoal] = useState(0);

  function setCheckCard(consume: number) {
    onSetCheckCard(consume);
  }

  function setCreditCard(consume: number) {
    onSetCreditCard(consume);
  }

  const memberId = 1;

  useEffect(() => {
    axios.get(`/settlement/${memberId}/not-achievement`).then(({ data }) => {
      setAccumulate(data.annualConsume);
      setGoal(data.settlementStandard);
      setCheckCard(data.annualCheckConsume);
      setCreditCard(data.annualCreditConsume);
    });
  }, [salary]);

  return (
    <div>
      <div className="mt-10">
        <div className="flex justify-center mb-1">
          <span>연말정산을 받기 위해 사용해야하는 금액</span>
        </div>

        <div>
          <ProgressBar value={accumulate} total={goal} />
        </div>

        <div className="flex justify-between">
          {
            accumulate < 100000000
            ? <span>{Math.floor(accumulate / 10000)}만원</span>
            : ( (accumulate / 10000) - Math.floor(accumulate / 100000000)*10000 == 0 ) ? <span>{Math.floor(accumulate / 100000000)}억원</span>
            : <span>{Math.floor(accumulate / 100000000)}억{Math.floor(accumulate / 10000) - Math.floor(accumulate / 100000000)*10000}만원</span>
          }
          {
            goal < 100000000
            ? <span>{Math.floor(goal / 10000)}만원</span>
            : ( (goal / 10000) - Math.floor(goal / 100000000)*10000 == 0 ) ? <span>{Math.floor(goal / 100000000)}억원</span>
            : <span>{Math.floor(goal / 100000000)}억{Math.floor(goal / 10000) - Math.floor(goal / 100000000)*10000}만원</span>
          }
        </div>
      </div>

      <div className="mt-5">
        <div className="text-3xl"><span className="font-semibold">{userName}</span>님은</div>
        <div className="text-xl">카드소득공제를 받을 수 없어요.</div>
        <div className="mt-2">
          소비 금액이 소득의 25%를 넘어야 공제가 시작돼요.
        </div>
      </div>
    </div>
  )
}