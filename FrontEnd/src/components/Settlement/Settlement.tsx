import MyIncome from "./MyIncome";
import MyUsage from "./MyUsage";
import Achieved from "./Achieved";
import NotAchieved from "./NotAchieved";

import { useState, useEffect } from "react";
import { axios } from "../../api";
import useAuthStore from "../../store/AuthStore";

export default function Settlement() {
  const [isLoading, setLoading] = useState(true);

  const [isAchieved, setAchieved] = useState(false);
  const [salary, setSalary] = useState(0);
  const [checkCard, setCheckCard] = useState(0);
  const [creditCard, setCreditCard] = useState(0);

  function onSetSalary(salary: number) {
    setSalary(salary);
  }

  function onSetCheckCard(consume: number) {
    setCheckCard(consume);
  }
  function onSetCreditCard(consume: number) {
    setCreditCard(consume);
  }

  const { memberId, name } = useAuthStore();

  useEffect(() => {
    axios
      .get(`/settlement/${memberId}/achievement-standard`)
      .then(({ data }) => {
        setAchieved(data.achieve);
      })
      .finally(() => {
        setLoading(false);
      });
  }, [salary]);

  if (isLoading) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      <MyIncome userName={name} salary={salary} onSetSalary={onSetSalary} />
      {isAchieved ? (
        <Achieved
          userName={name}
          salary={salary}
          onSetCheckCard={onSetCheckCard}
          onSetCreditCard={onSetCreditCard}
        />
      ) : (
        <NotAchieved
          userName={name}
          salary={salary}
          onSetCheckCard={onSetCheckCard}
          onSetCreditCard={onSetCreditCard}
        />
      )}
      <MyUsage checkCard={checkCard} creditCard={creditCard} />
    </div>
  );
}
