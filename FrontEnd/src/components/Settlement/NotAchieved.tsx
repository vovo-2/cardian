import ProgressBar from "../ui/ProgressBar";

interface NotAchievedProps {
    userName: string;
    accumulate: number;
    goal: number;
}

export default function NotAchieved({userName, accumulate, goal}: NotAchievedProps) {
  return (
    <div>
      <div className="mt-2">
        <div className="flex justify-center mb-1">
          <span>연말정산을 받기 위해 사용해야하는 금액</span>
        </div>

        <div>
          <ProgressBar value={accumulate} total={goal} />
        </div>

        <div className="flex justify-between">
          <span>{(accumulate / 10000).toLocaleString()}만원</span>
          <span>{(goal / 10000).toLocaleString()}만원</span>
        </div>
      </div>

      <div className="mt-5">
        <div className="text-3xl"><span className="font-semibold">{userName}</span>님은</div>
        <div className="text-2xl">카드소득공제를 받을 수 없어요.</div>
        <div className="mt-2">
          소비 금액이 소득의 25%를 넘어야 공제가 시작돼요.
        </div>
      </div>
    </div>
  )
}