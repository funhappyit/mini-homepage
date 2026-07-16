import apiClient from './client'

export interface VisitStats {
  today: number
  total: number
}

export async function fetchVisitStats(): Promise<VisitStats> {
  const { data } = await apiClient.get<VisitStats>('/api/v1/visits')
  return data
}

export async function incrementVisit(): Promise<VisitStats> {
  const { data } = await apiClient.post<VisitStats>('/api/v1/visits/increment')
  return data
}
