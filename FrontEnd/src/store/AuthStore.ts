import { create } from "zustand";
import { createJSONStorage, persist } from "zustand/middleware";

interface AuthState {
  memberId: number | null;
  isLoggedIn: boolean;
  login: (memberId: number) => void;
  logout: () => void;
}

const useAuthStore = create<AuthState>()(
  persist(
    (set) => ({
      memberId: null,
      isLoggedIn: false,
      login: (memberId: number) => set({ memberId, isLoggedIn: true }),
      logout: () => set({ memberId: null, isLoggedIn: false }),
    }),
    {
      name: "auth",
      storage: createJSONStorage(() => sessionStorage),
    }
  )
);

export default useAuthStore;
