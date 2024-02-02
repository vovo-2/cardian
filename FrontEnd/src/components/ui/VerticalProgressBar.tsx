interface progressProps {
  total: number;
  value: number;
}

export default function ProgressBar({ total, value }: progressProps) {
  const pro: number = value / total;

  return (
    <div className="flex justify-center">
      <div className="bg-lightgray rounded-lg w-20 h-52 flex flex-col-reverse">
        <div
          className="bg-blue rounded-b-lg w-20"
          style={{ height: `${pro * 208}px` }}
        ></div>
      </div>
    </div>
  );
}