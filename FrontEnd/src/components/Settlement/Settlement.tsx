import MyIncome from "./MyIncome";
import MyUsage from "./MyUsage";
import Achieved from "./Achieved";
import NotAchieved from "./NotAchieved";

const userName: string = "이서준";
const income: number = 40000000;
const checkCard: number = 4000000; // 넘어오는 값
const creditCard: number = 3600000; // 넘어오는 값
const accumulate: number = checkCard + creditCard;
const goal: number = 10000000; // 넘어오는 값
const maxSettlement: number = 3000000; // 넘어오는 값
const mySettlement: number = 1234567; // 넘어오는 값

const isAchieved: boolean = false;

export default function SettlementPage() {

  return (
    <div>
      <MyIncome userName={userName} income={income} />
      {
        isAchieved
        ? <Achieved userName={userName} maxSettlement={maxSettlement} mySettlement={mySettlement} />
        : <NotAchieved userName={userName} accumulate={accumulate} goal={goal} />
      }
      <MyUsage checkCard={checkCard} creditCard={creditCard} />
    </div>
  );
}