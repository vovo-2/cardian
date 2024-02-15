import { useState, useEffect } from "react"

import { axios } from "../../api"
import VerticalProgressBar from "../ui/VerticalProgressBar";
import useAuthStore from "../../store/AuthStore";

interface AchievedProps {
  userName: string;
  salary: number;
  onSetCheckCard: (consume: number) => void;
  onSetCreditCard: (consume: number) => void;
}

export default function Achieved({ userName, salary, onSetCheckCard, onSetCreditCard }: AchievedProps) {
  
  const [maxSettlement, setMaxSettlement] = useState(0);
  const [mySettlement, setMySettlement] = useState(0);

  function setCheckCard(consume: number) {
    onSetCheckCard(consume);
  }

  function setCreditCard(consume: number) {
    onSetCreditCard(consume);
  }

  const { memberId } = useAuthStore();

  useEffect(() => {
    axios.get(`/settlement/${memberId}/achievement`)
    .then(({ data }) => {
      setMaxSettlement(data.maxSettlement);
      setMySettlement(data.mySettlement);
      setCheckCard(data.annualCheckConsume);
      setCreditCard(data.annualCreditConsume);
    });
  }, [salary]);

  return (
    <div>
      <div>
        <div className="flex justify-center text-2xl mt-10">
          {userName}님은 연말정산 혜택을
        </div>
        <div className="flex justify-center text-2xl">받을 수 있어요!</div>
      </div>

      <div className="flex justify-center mt-5">
        <div className="w-full flex flex-col">
          <div className="flex justify-center">
            <div className="bg-gray rounded-lg w-20 h-52 flex flex-col-reverse"></div>
          </div>
          <div className="flex justify-center mt-2">
            <span className="text-sm">최대 공제 금액</span>
          </div>
          <div className="flex justify-center">
            <span className="text-sm">{maxSettlement.toLocaleString()}원</span>
          </div>
        </div>

        <div className="w-full flex flex-col">
          <div className="flex justify-center">
            <div>
              <VerticalProgressBar total={maxSettlement} value={mySettlement} />
            </div>
          </div>
          <div className="flex justify-center mt-2">
            <span className="text-sm">내 공제 금액</span>
          </div>
          <div className="flex justify-center">
            <span className="text-sm">{mySettlement.toLocaleString()}원</span>
          </div>
        </div>
      </div>
    </div>
  );
}
