interface IncomeProps {
    userName: string;
    income: number;
}

export default function MyIncome( {userName, income} : IncomeProps ) {
  return (
    <div>
      <span className="flex justify-center text-3xl">
        {userName}님의 연봉&nbsp;<span className="text-blue font-semibold">{(income / 10000).toLocaleString()}</span>만원
      </span>
      <div className="flex justify-end">
        <button
          type="button"
          className="text-gray-900 bg-white border border-gray-300 focus:outline-none hover:bg-gray-100 font-medium rounded-full text-sm px-3 py-1.5 me-1 mb-1"
        >
          수정
        </button>
      </div>
    </div>
  );
}
